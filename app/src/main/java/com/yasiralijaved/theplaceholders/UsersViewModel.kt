package com.yasiralijaved.theplaceholders

import androidx.lifecycle.*
import com.yasiralijaved.core.data.domain.DomainUser
import com.yasiralijaved.core.data.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class UsersViewModel : ViewModel() {

//    private val _users: MutableLiveData<List<DomainUser>> = MutableLiveData()
//    val users: LiveData<List<DomainUser>> = _users

    public val users = UserRepository.instance.getUsers().asLiveData()

//    init {
//        viewModelScope.launch {
//            getUsersFlow.collect { users ->
//                // make a shallow copy
//                _users.value = users.map { it }
//            }
//        }
//    }
}