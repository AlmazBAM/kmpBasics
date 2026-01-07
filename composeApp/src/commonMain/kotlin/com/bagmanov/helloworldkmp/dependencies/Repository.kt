package com.bagmanov.helloworldkmp.dependencies

interface Repository {
    fun getHelloWorld(): String
}


class RepositoryImpl(
    private val dbClient: DbClient
): Repository {
    override fun getHelloWorld(): String {
        return "Alloha world"
    }
}