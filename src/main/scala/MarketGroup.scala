package alexadewit_on_github.icelandic_economy.db

import argonaut._, Argonaut._, DecodeResult._
import scalaz._, scalaz.syntax.either._

case class MarketGroup( id: EveId, parentId: EveId, name: String, description: String )

object MarketGroupCrestDecoders {

  import EveIdCrestDecoders._
  
  implicit def MarketGroupDecodeJson : DecodeJson[MarketGroup] = {
    DecodeJson( c => for {
      id <- ( c --\ "href" ).as[EveId]
      parentId <- ( c --\ "parentGroup" ).as[EveId]
      name <- ( c --\ "name" ).as[String]
      description <- ( c --\ "description" ).as[String]
    } yield MarketGroup( id, parentId, name, description ) )
  }
}

