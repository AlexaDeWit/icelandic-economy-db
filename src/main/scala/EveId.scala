package alexadewit_on_github.icelandic_economy.db

import argonaut._, Argonaut._, DecodeResult._
import scalaz._, scalaz.syntax.either._

case class EveId( id: Long )

object EveId {

  def fromHrefString( s: String ): String \/ EveId = {
    s match {
      case marketGroup( n ) => EveId(n.toLong).right
      case _                => s"Id could not be parsed from ${s}".left
    }
  }

  val marketGroup = """https://public-crest.eveonline.com/market/groups/(\d+)/""".r

}
//Crest decoding is one way, we will use our own codecs internally for anything else
//We're not going to let Crest dictate our internal json structure. We'll fix it once on its
//way in and then NEVER AGAIN
object EveIdCrestDecoders {

  //dat name do
  def eveIdHrefDecodeJson : DecodeJson[EveId] = {
    DecodeJson( ( cursor: HCursor ) => {
      cursor.as[String].flatMap {
        case c: String => JsonDecoders.fromValue( c, cursor )( EveId.fromHrefString )
      }
    })
  }

  def eveIdInnerHrefDecodeJson : DecodeJson[EveId] = {
    DecodeJson( ( cursor: HCursor ) =>  {
      ( cursor --\ "href" ).as[String].flatMap {
        case c: String => JsonDecoders.fromValue( c, cursor )( EveId.fromHrefString )
      }
    } )
  }

  def eveIdFromLongIdDecodeJson : DecodeJson[EveId] = {
    jdecode1L(EveId.apply)("id")
  }

  implicit def EveIdDecodeJson : DecodeJson[EveId] = {
    eveIdFromLongIdDecodeJson ||| eveIdHrefDecodeJson ||| eveIdInnerHrefDecodeJson
  }
}
