package com.gilbersoncampos.detona.data.repository

import com.gilbersoncampos.detona.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepositoryInterface{
    fun getUser(): Flow<User?>
    fun setUser()
}