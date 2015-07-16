package alexadewit_on_github.icelandic_economy.crest

import argonaut._, Argonaut._, DecodeResult._

import alexadewit_on_github.icelandic_economy.db._

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

