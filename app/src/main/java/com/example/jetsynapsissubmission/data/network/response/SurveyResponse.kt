package com.example.jetsynapsissubmission.data.network.response

import com.google.gson.annotations.SerializedName

data class SurveyResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("total_all_data")
	val totalAllData: Int? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataItem(

	@field:SerializedName("updated_at")
	val updatedAt: String? = null,

	@field:SerializedName("questions")
	val questions: List<QuestionsItem?>? = null,

	@field:SerializedName("created_at")
	val createdAt: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("total_respondent")
	val totalRespondent: Int? = null,

	@field:SerializedName("survey_name")
	val surveyName: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class QuestionsItem(

	@field:SerializedName("question_name")
	val questionName: String? = null,

	@field:SerializedName("input_type")
	val inputType: String? = null,

	@field:SerializedName("question_id")
	val questionId: String? = null
)
