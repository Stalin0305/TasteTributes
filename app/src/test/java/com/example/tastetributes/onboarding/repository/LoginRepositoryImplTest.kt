package com.example.tastetributes.onboarding.repository

import com.example.tastetributes.database.dao.UserDao
import com.example.tastetributes.features.onboarding.data.mappers.toDomain
import com.example.tastetributes.features.onboarding.data.models.UserResponseModel
import com.example.tastetributes.features.onboarding.data.repository.local.LoginRepositoryImpl
import com.example.tastetributes.features.onboarding.domain.models.UserData
import com.example.tastetributes.features.onboarding.domain.repository.LoginRepository
import com.example.tastetributes.features.onboarding.domain.services.AuthenticationService
import com.example.tastetributes.utils.Status
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LoginRepositoryImplTest {

//    @get:Rule
//    val mainTestDispatcher = MainTestDispatcher()

    private lateinit var underTest: LoginRepository

    @RelaxedMockK
    private lateinit var authenticationService: AuthenticationService

    @RelaxedMockK
    private lateinit var userDao: UserDao

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        underTest = LoginRepositoryImpl(authenticationService, userDao)
    }

    @Test
    fun `given email and password, verify if the login was successful and userData returns status as success`() =
        runBlocking {
            val userResponseModel =
                UserResponseModel(
                    email = "",
                    status = Status.Success,
                    userName = "",
                    uuid = "",
                    token = "",
                )
            val userDataModel = userResponseModel.toDomain()
            val userData = UserData(data = userDataModel, status = Status.Success)
            coEvery { authenticationService.login("", "") } returns flowOf(Result.success(userResponseModel))

            val emisions =  underTest.loginWithEmailAndPassword("", "")
                .take(2)
                .toList()

            Assert.assertEquals(userData, emisions.last())

        }

    @Test
    fun `given email and password, verify if the login was not successful and userData returns status as error` ()=
        runBlocking {
            val userData = UserData(data = null, status = Status.Error, error = "Something went wrong")
            coEvery { authenticationService.login("", "") } returns flowOf(Result.failure(Exception("Something went wrong")))

            val emisions =  underTest.loginWithEmailAndPassword("", "")
                .take(2)
                .toList()

            Assert.assertEquals(userData, emisions.last())
        }

}