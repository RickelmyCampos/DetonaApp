package com.gilbersoncampos.detona.data.local.datasource

import com.gilbersoncampos.detona.data.model.User
import kotlinx.coroutines.flow.Flow

interface UserLocalDataSourceInterface {
    fun getUser(): Flow<User?>
    fun setUser()
}