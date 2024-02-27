package com.gilbersoncampos.detona.data.local.datasource

import com.gilbersoncampos.detona.data.model.User
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserLocalDataSource @Inject constructor():UserLocalDataSourceInterface {

    private var userData:User?= null
    override fun getUser(): Flow<User?> {
        return flow {
            delay(5000)
            emit(userData)
        }
    }
   override fun setUser(){
        userData= User(name = "Gilberson", id = "5as654A4a8w4sd548")
    }





}

