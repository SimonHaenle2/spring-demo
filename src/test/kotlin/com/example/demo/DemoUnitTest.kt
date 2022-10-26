package com.example.demo

import com.example.demo.repository.DemoUser
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DemoUnitTest {

	private val repository: UserRepository = mockk()
	private val cut: UserService = UserService(repository)

	@Test
	fun `getUsers calls correct repository method`() {
		every { repository.findAll() } returns listOf(
			DemoUser(firstName = "Max", lastName = "MusterMann", street = "Musterstreet", houseNo = "1", city = "Musterstadt", zipCode = "70794")
		)

		cut.getUsers()

		assertThat(repository.findAll())
	}

}
