package domain

import org.scalatest.{FlatSpec, Matchers}

class AddressBookTest extends FlatSpec with Matchers {
  val mark = Person("mark", "newton", "9987778")
  val sam = Person("sam", "yank", "99123")
  val bangalore = Address("Bangalore", "Kar", "577", "#22, 2nd Street")
  val mumbai = Address("Mumbai", "MH", "122", "#22, 2nd Street")

  "AddressBook" should "add an entry to its set of entries" in {
    val entry = Entry(mark, bangalore)

    val addressBook = AddressBook(List()).add(entry)
    addressBook.entries.size shouldEqual 1
    addressBook.entries.contains(entry) shouldBe true
  }

  "AddressBook" should "remove an entry from its set of entries" in {
    val entry = Entry(mark, bangalore)
    val addressBook = AddressBook(List(entry))
    addressBook.entries.size shouldEqual 1

    val updatedAddressBook = addressBook.remove(entry)
    updatedAddressBook.entries.size shouldEqual 0
  }

  "AddressBook" should "not remove an entry from when its not present in its entries" in {
    val addressBook = AddressBook(List(Entry(mark, bangalore)))
    addressBook.entries.size shouldEqual 1
    val entry = Entry(Person("newton", "mark", "9987778"), bangalore)

    val updatedAddressBook = addressBook.remove(entry)
    updatedAddressBook.entries.size shouldEqual 1
  }

  "AddressBook" should "should be able to edit the address" in {
    val markEntry = Entry(mark, bangalore)
    val addressBook = AddressBook(List(markEntry))

    val updatedEntry = markEntry.editAddress(mumbai)

    val updatedAddressBook = addressBook.edit(markEntry, updatedEntry)
    updatedAddressBook.isPresent(updatedEntry) shouldEqual true
  }

  "AddressBook" should "sort entries by last name" in {
    val markEntry = Entry(mark, bangalore)
    val samEntry = Entry(mark, bangalore)
    val addressBook = AddressBook(List(samEntry, markEntry))
    addressBook.sortBy(LastNameEntryOrdering) shouldEqual List(markEntry, samEntry)
  }

  "AddressBook" should "sort entries by zip code" in {
    val markEntry = Entry(mark, mumbai)
    val samEntry = Entry(mark, bangalore)
    val addressBook = AddressBook(List(samEntry, markEntry))
    addressBook.sortBy(ZipCodeEntryOrdering) shouldEqual List(markEntry, samEntry)
  }
}
