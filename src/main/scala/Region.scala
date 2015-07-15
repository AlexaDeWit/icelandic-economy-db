package alexadewit_on_github.icelandic_economy.db

import argonaut._, Argonaut._, DecodeResult._

case class Region( id: Long, name: String )

object RegionCrestDecoders {

  import EveIdCrestDecoders._

  implicit def RegionDecodeJson : DecodeJson[Region] = {
    DecodeJson( c => for {
      id <- ( c--\ "href" ).as[EveId]
      name <- ( c --\ "name" ).as[String]
    } yield Region( id, name ) )
  }
}
