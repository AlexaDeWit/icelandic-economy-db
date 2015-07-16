package alexadewit_on_github.icelandic_economy.db

import argonaut._, Argonaut._, DecodeResult._
import scalaz._, scalaz.syntax.either._

//Represents a specific Eve item's market status
case class MarketType( id: Long, marketGroupId: Long, name: String, iconUrl: String )
