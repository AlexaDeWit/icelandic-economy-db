package alexadewit_on_github.icelandic_economy.crest

import argonaut._, Argonaut._, DecodeResult._
import scalaz._, scalaz.syntax.either._

import alexadewit_on_github.icelandic_economy.db._


object MarketTypeCrestDecoders {

  import EveIdCrestDecoders._

  implicit def MarketTypeDecodeJson : DecodeJson[MarketType] = {
    DecodeJson( c => for {
      marketGroupId   <- ( c --\ "marketGroup" --\ "id" ).as[Long]
      id              <- ( c --\ "type" --\ "id" ).as[Long]
      name            <- ( c --\ "type" --\ "name" ).as[String]
      iconUrl         <- ( c --\ "type" --\ "icon" --\ "href" ).as[String]
    } yield MarketType( id, marketGroupId, name, iconUrl ) )
  }

}
