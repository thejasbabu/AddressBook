package domain

import org.scalatest.{FlatSpec, Matchers}

class AddressBookTest extends FlatSpec with Matchers {
  "AddressBook" should "add an entry to its set of entries" in {
    val person = Person("mark", "newton", "9987778")
    val address = Address("Bangalore", "Kar", "577", "#22, 2nd Street")
    val entry = Entry(person, address)
    val addressBook = AddressBook(Set()).add(entry)
    addressBook.entries.size shouldEqual 1
    addressBook.entries.contains(entry) shouldBe true
  }
}
