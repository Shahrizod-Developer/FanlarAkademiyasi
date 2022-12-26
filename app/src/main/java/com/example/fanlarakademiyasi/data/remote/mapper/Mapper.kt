package com.example.fanlarakademiyasi.data.remote.mapper

import com.example.fanlarakademiyasi.data.model.*
import com.example.fanlarakademiyasi.data.remote.firebase.response.ArticleResponse
import com.google.firebase.firestore.DocumentSnapshot

object Mapper {

    fun DocumentSnapshot.toCategoryData() = Category(
        id = this["id"].toString(),
        title = this["title"].toString(),
        code = this["code"].toString().toInt()
    )

    fun DocumentSnapshot.toChildCategory() = ChildCategory(
        id = this["id"].toString(),
        title = this["title"].toString(),
        code = this["code"].toString().toInt(),
        categoryCode = this["category_code"].toString().toInt()
    )

    fun DocumentSnapshot.toArticle() = ArticleResponse(
        id = this["id"].toString(),
        childCategoryCode = this["child_category_code"].toString().toInt(),
        image = this["image"].toString(),
        title = this["title"].toString(),
        desc = this["desc"].toString(),
        text = this["text"].toString(),
        date = this["date"].toString(),
        seenCount = this["seen_count"].toString().toInt(),
        storageUrl = this["storage_url"].toString()
    )

    fun DocumentSnapshot.toDecree() = Decree(
        id = this["id"].toString(),
        title = this["title"].toString(),
        desc = this["desc"].toString(),
        text = this["text"].toString(),
        storageUrl = this["storage_url"].toString()
    )

    fun DocumentSnapshot.toNew() = New(
        id = this["id"].toString(),
        title = this["title"].toString(),
        publicationDate = this["publication_date"].toString(),
        image = this["image"].toString(),
        time = this["time"].toString(),
        seenCount = this["seen_count"].toString().toInt()
    )

    fun DocumentSnapshot.toOpenData() = OpenData(
        id = this["id"].toString(),
        title = this["title"].toString(),
        publicationDate = this["publication_date"].toString(),
        format = this["format"].toString(),
        storageUrl = this["storage_url"].toString()
    )

    fun DocumentSnapshot.toPhoto() = Photo(
        id = this["id"].toString(),
        title = this["title"].toString(),
        storageUrl = this["storage_url"].toString(),
        desc = this["desc"].toString(),
        date = this["date"].toString(),
        seenCount = this["seen_count"].toString().toInt()
    )

    fun DocumentSnapshot.toVideo() = Video(
        id = this["id"].toString(),
        title = this["title"].toString(),
        storageUrl = this["storage_url"].toString(),
        desc = this["desc"].toString(),
        date = this["date"].toString(),
        seenCount = this["seen_count"].toString()
    )

    fun DocumentSnapshot.toPresident() = President(
        id = this["id"].toString(),
        fullName = this["full_name"].toString(),
        image = this["image"].toString(),
        desc = this["desc"].toString()
    )

    fun DocumentSnapshot.toQuestionnaire() = Questionnaire(
        id = this["id"].toString(),
        question = this["question"].toString(),
        ansOne = this["ans_one"].toString(),
        ansTwo = this["ans_two"].toString(),
        ansThree = this["ans_three"].toString(),
        ansFour = this["ans_four"].toString(),
        ansTrue = this["ans_true"].toString()
    )

    fun DocumentSnapshot.toResult() = Result(
        id = this["id"].toString(),
        ansOne = this["ans_one"].toString(),
        ansTwo = this["ans_two"].toString(),
        ansThree = this["ans_three"].toString(),
        ansFour = this["ans_four"].toString(),
        allAnswer = this["ans_answer"].toString()
    )

    fun DocumentSnapshot.toSection() = Section(
        id = this["id"].toString(),
        name = this["name"].toString(),
        image = this["image"].toString(),
        responsiblePerson = this["responsiblePerson"].toString(),
        phone = this["phone"].toString(),
        email = this["email"].toString(),
        employeesCount = this["employees_count"].toString().toInt()
    )
}