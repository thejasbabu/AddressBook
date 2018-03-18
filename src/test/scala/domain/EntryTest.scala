package domain

import org.scalatest.{FlatSpec, Matchers}

class EntryTest extends FlatSpec with Matchers {
    "Entry" should "edit the address of a person" in {
      val mark = Person("mark", "newton", "9987778")
      val bangalore = Address("Bangalore", "Kar", "577", "#22, 2nd Street")
      val mumbai = Address("Mumbai", "MH", "577", "#22, 2nd Street")

      Entry(mark, bangalore).editAddress(mumbai) shouldEqual Entry(mark, mumbai)
    }
}
