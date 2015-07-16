package alexadewit_on_github.icelandic_economy.db

import argonaut._, Argonaut._, DecodeResult._
import scalaz._, scalaz.syntax.either._

case class EveId( id: Long )

object EveId {

  implicit def toLong( id: EveId ) = EveId.unapply( id ).get

}
