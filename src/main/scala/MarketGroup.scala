package alexadewit_on_github.icelandic_economy.db

import argonaut._, Argonaut._, DecodeResult._

case class MarketGroup( id: Long, parentId: Long, name: String, description: String )
