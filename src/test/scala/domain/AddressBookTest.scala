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

  "AddressBook" should "remove an entry from its set of entries" in {
    val person = Person("mark", "newton", "9987778")
    val address = Address("Bangalore", "Kar", "577", "#22, 2nd Street")
    val entry = Entry(person, address)
    val addressBook = AddressBook(Set(entry))
    addressBook.entries.size shouldEqual 1
    val updatedAddressBook = addressBook.remove(entry)
    updatedAddressBook.entries.size shouldEqual 0
  }

  "AddressBook" should "not remove an entry from when its not present in its entries" in {
    val person = Person("mark", "newton", "9987778")
    val address = Address("Bangalore", "Kar", "577", "#22, 2nd Street")
    val addressBook = AddressBook(Set(Entry(person, address)))
    addressBook.entries.size shouldEqual 1
    val entry = Entry(Person("newton", "mark", "9987778"), address)
    val updatedAddressBook = addressBook.remove(entry)
    updatedAddressBook.entries.size shouldEqual 1
  }

  "AddressBook" should "should be able to edit the address" in {
    val mark = Person("mark", "newton", "9987778")
    val bangalore = Address("Bangalore", "Kar", "577", "#22, 2nd Street")
    val mumbai = Address("Mumbai", "MH", "577", "#22, 2nd Street")
    val markEntry = Entry(mark, bangalore)

    val addressBook = AddressBook(Set(markEntry))

    val updatedEntry = markEntry.editAddress(mumbai)

    val updatedAddressBook = addressBook.edit(markEntry, updatedEntry)
    updatedAddressBook.isPresent(updatedEntry) shouldEqual true
  }
}
