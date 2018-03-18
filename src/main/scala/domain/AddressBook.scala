package domain

case class AddressBook(entries: Set[Entry]) {
  def add(entry: Entry): AddressBook = {
    AddressBook(this.entries + entry)
  }

  def remove(entry: Entry): AddressBook = {
    AddressBook(this.entries - entry)
  }

  def edit(oldEntry: Entry, updatedEntry: Entry) = {
    if(isPresent(oldEntry)) remove(oldEntry).add(updatedEntry)
    else add(updatedEntry)
  }

  def isPresent(entry: Entry) = {
    this.entries.contains(entry)
  }
}