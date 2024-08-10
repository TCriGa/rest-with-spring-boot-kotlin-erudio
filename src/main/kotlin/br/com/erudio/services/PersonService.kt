package br.com.erudio.services

import br.com.erudio.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {
    private val counter: AtomicLong = AtomicLong()
    private val logger = Logger.getLogger(PersonService::class.java.name)
    fun findAll(): List<Person> {
        logger.info("Find all people!")
        val people = mutableListOf<Person>()

        for (i in 0..7) {
            val person = mockPerson(i)

            people.add(person)
        }
        return people
    }

    fun findById(id: Long): Person {
        logger.info("Fetching person with id: $id")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Thayana"
        person.lastName = "Gayva"
        person.address = "Cuiabá-MT"
        person.gender = "Female"

        return person
    }

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long){}

    private fun mockPerson(i: Int): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person name $i"
        person.lastName = "Last name $i"
        person.address = "Cuiabá-MT"
        person.gender = "Male"

        return person
    }
}