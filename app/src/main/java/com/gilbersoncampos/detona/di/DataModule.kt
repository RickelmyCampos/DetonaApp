package com.gilbersoncampos.detona.di

import com.gilbersoncampos.detona.data.local.datasource.UserLocalDataSource
import com.gilbersoncampos.detona.data.local.datasource.UserLocalDataSourceInterface
import com.gilbersoncampos.detona.data.repository.UserRepository
import com.gilbersoncampos.detona.data.repository.UserRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Singleton


@Module
@InstallIn(ViewModelComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindUserRepository(userRepository: UserRepository): UserRepositoryInterface

    @Binds
    abstract fun bindUserLocalDataSource(userRepository: UserLocalDataSource): UserLocalDataSourceInterface
}
