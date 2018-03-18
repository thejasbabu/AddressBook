package domain

import scala.math.Ordering

case class AddressBook(entries: List[Entry]) {
  def add(entry: Entry): AddressBook = {
    AddressBook(this.entries :+ entry)
  }

  def remove(entry: Entry): AddressBook = {
    AddressBook(this.entries.filterNot(_.equals(entry)))
  }

  def edit(oldEntry: Entry, updatedEntry: Entry) = {
    if (isPresent(oldEntry)) remove(oldEntry).add(updatedEntry)
    else add(updatedEntry)
  }

  def isPresent(entry: Entry) = {
    this.entries.contains(entry)
  }

  def sortBy(implicit ord: Ordering[Entry]): List[Entry] = {
    this.entries.sorted
  }
}