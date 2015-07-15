package alexadewit_on_github.icelandic_economy.db

import argonaut._, Argonaut._, DecodeResult._
import scalaz._

object JsonDecoders {
  def fromValue[A,B]( someVal: A, cursor: HCursor )( parsingFunction: A => \/[String, B] ): DecodeResult[B] = {
    val parseResult =   parsingFunction( someVal )
    parseResult.fold( message => fail( message, cursor.history ), ok )
  }

}
