package domain

case class AddressBook(entries : Set[Entry]) {
  def add(entry: Entry): AddressBook = {
    AddressBook(this.entries + entry)
  }
}