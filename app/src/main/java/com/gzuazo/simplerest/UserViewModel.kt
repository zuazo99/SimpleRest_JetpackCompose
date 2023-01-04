package com.gzuazo.simplerest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gzuazo.simplerest.datasource.database.entities.UserEntity
import com.gzuazo.simplerest.domain.DeleteUserUseCase
import com.gzuazo.simplerest.domain.GetAllUsersUseCase
import com.gzuazo.simplerest.domain.GetNewUserUseCase
import com.gzuazo.simplerest.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getNewUserUseCase: GetNewUserUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val deleteUserUseCase: DeleteUserUseCase
) : ViewModel() {

    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    val users: LiveData<List<User>> by lazy {
        getAllUsersUseCase()
    }

    val isLoading: LiveData<Boolean> get() = _isLoading


    fun addUser() {
        if (_isLoading.value == false) {
            viewModelScope.launch(Dispatchers.IO) {
                _isLoading.postValue(true)
                getNewUserUseCase()
                _isLoading.postValue(false)
            }
        }
    }

    fun deleteUser(toDelete: User) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteUserUseCase(toDelete)
        }
    }
}