package alexadewit_on_github.icelandic_economy.crest

import argonaut._, Argonaut._, DecodeResult._

import alexadewit_on_github.icelandic_economy.db._

object RegionCrestDecoders {

  import EveIdCrestDecoders._

  implicit def RegionDecodeJson : DecodeJson[Region] = {
    DecodeJson( c => for {
      id <- ( c--\ "href" ).as[EveId]
      name <- ( c --\ "name" ).as[String]
    } yield Region( id, name ) )
  }
}
