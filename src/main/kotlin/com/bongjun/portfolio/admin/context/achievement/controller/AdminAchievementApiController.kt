package com.bongjun.portfolio.admin.context.achievement.controller

import com.bongjun.portfolio.admin.context.achievement.form.AchievementForm
import com.bongjun.portfolio.admin.context.achievement.service.AdminAchievementService
import com.bongjun.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/achievements")
class AdminAchievementApiController(
    private val adminAchievementService: AdminAchievementService
) {

    @PostMapping()
    fun postAchievement(@RequestBody @Validated form : AchievementForm): ResponseEntity<Any> {
        adminAchievementService.save(form)

        return ApiResponse.successCreate()
    }

    @PostMapping("/{id}")
    fun postAchievement(@PathVariable id : Long, @RequestBody form : AchievementForm): ResponseEntity<Any> {
        adminAchievementService.update(id , form)

        return ApiResponse.successUpdate()
    }

}