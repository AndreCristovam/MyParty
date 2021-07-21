package com.andrecristovam.myparty.service.repository


import android.content.Context
import com.andrecristovam.myparty.service.model.GuestModel

class GuestRepository(context: Context) {

    // Acesso ao banco de dados
    private val mDataBase = GuestDatabase.getDatabase(context).guestDAO()



     // Carrega convidado
    fun get(id: Int): GuestModel {
        return mDataBase.get(id)
    }


     // Insere convidado
    fun save(guest: GuestModel): Boolean {
        return  mDataBase.save(guest) > 0
    }


     // Faz a listagem de todos os convidados
    fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }


     // Faz a listagem de todos os convidados presentes
    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()
    }


     // Faz a listagem de todos os convidados presentes
    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }


     // Atualiza convidado
    fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0
    }


     // Remove convidado
    fun delete(guest: GuestModel) {
        mDataBase.delete(guest)
    }

}