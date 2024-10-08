package br.com.erudio.services

import br.com.erudio.exceptions.ResourceNotFoundException
import br.com.erudio.model.Person
import br.com.erudio.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {
    @Autowired
    private lateinit var repository: PersonRepository
    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {
        logger.info("Find all people!")
     return  repository.findAll()
    }

    fun findById(id: Long): Person {
        logger.info("Fetching person with id: $id")
        return repository.findById(id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID: $id!") }
    }

    fun create(person: Person) : Person {
        logger.info("Creating new person with name: ${person.firstName}")
       return repository.save(person)

    }
    fun update(person: Person) : Person{
        logger.info("Updating one person with ID ${person.id}!")
        val entity = repository.findById(person.id)
            .orElseThrow { ResourceNotFoundException("No records found for this ID!") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender
        return repository.save(entity)
    }

    fun delete(id: Long){
        logger.info("Deleting person with id : $id")
        val entity = repository.findById(id).orElseThrow{ ResourceNotFoundException("No records found for this ID: $id")}
        repository.delete(entity)
    }
}