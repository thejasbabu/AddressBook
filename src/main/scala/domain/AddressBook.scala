package domain

case class AddressBook(entries: Set[Entry]) {
  def add(entry: Entry): AddressBook = {
    AddressBook(this.entries + entry)
  }

  def remove(entry: Entry): AddressBook = {
    AddressBook(this.entries - entry)
  }

  def find(person: Person): Option[Entry] = {
    val entry = this.entries.filter(_.person.equals(person))
    entry.headOption
  }
}