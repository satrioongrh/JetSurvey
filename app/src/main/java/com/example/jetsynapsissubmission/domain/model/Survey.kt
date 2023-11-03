package com.example.jetsynapsissubmission.domain.model

data class Survey(
    val code: Int? = null,
    val data: List<DataDomain?>? = null,
    val message: String? = null,
    val totalAllData: Int? = null,
    val status: Boolean? = null
)

data class DataDomain(
    val updatedAt: String? = null,
    val questions: List<Questions?>? = null,
    val createdAt: String? = null,
    val id: String? = null,
    val totalRespondent: Int? = null,
    val surveyName: String? = null,
    val status: Int? = null
)

data class Questions(

    val questionName: String? = null,
    val inputType: String? = null,
    val questionId: String? = null
)