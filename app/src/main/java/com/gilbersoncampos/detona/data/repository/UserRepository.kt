package com.gilbersoncampos.detona.data.repository

import com.gilbersoncampos.detona.data.model.User
import com.gilbersoncampos.detona.data.local.datasource.UserLocalDataSource
import com.gilbersoncampos.detona.data.local.datasource.UserLocalDataSourceInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject



class UserRepository @Inject constructor(private val userLocalDataSource: UserLocalDataSourceInterface):UserRepositoryInterface {
    override fun getUser() :Flow<User?>{
        return userLocalDataSource.getUser()
    }
    override fun setUser(){
        userLocalDataSource.setUser()
    }

}