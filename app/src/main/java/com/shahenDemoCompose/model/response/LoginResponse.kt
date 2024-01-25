package com.shahenDemoCompose.model.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("message")
    var message: String,
    @SerializedName("message_code")
    var messageCode: String,
    @SerializedName("status")
    var status: Boolean,
    @SerializedName("status_code")
    var statusCode: Int,
    @SerializedName("errors")
    var errors: Errors,
) {
    data class Data(
        @SerializedName("access_token")
        var accessToken: String,
        @SerializedName("permission")
        var permission: List<Any>,
        @SerializedName("role")
        var role: String,
        @SerializedName("user")
        var user: User
    ) {
        data class User(
            @SerializedName("absher_number")
            var absherNumber: Any,
            @SerializedName("absher_verification_updated_at")
            var absherVerificationUpdatedAt: String,
            @SerializedName("absher_verified")
            var absherVerified: Int,
            @SerializedName("authorization_letter")
            var authorizationLetter: String,
            @SerializedName("authorization_letter_url")
            var authorizationLetterUrl: String,
            @SerializedName("authorization_person")
            var authorizationPerson: String,
            @SerializedName("avatar")
            var avatar: Any,
            @SerializedName("avatar_thumb")
            var avatarThumb: String,
            @SerializedName("avatar_url")
            var avatarUrl: String,
            @SerializedName("bio")
            var bio: Any,
            @SerializedName("created_at")
            var createdAt: String,
            @SerializedName("designation_id")
            var designationId: Any,
            @SerializedName("device_token")
            var deviceToken: String,
            @SerializedName("email")
            var email: String,
            @SerializedName("email_verified")
            var emailVerified: Int,
            @SerializedName("email_verified_at")
            var emailVerifiedAt: String,
            @SerializedName("first_name")
            var firstName: String,
            @SerializedName("id")
            var id: Int,
            @SerializedName("img_url")
            var imgUrl: String,
            @SerializedName("insurance_expire_date")
            var insuranceExpireDate: Any,
            @SerializedName("is_completed")
            var isCompleted: Int,
            @SerializedName("last_name")
            var lastName: Any,
            @SerializedName("mobile")
            var mobile: String,
            @SerializedName("name")
            var name: String,
            @SerializedName("national_id")
            var nationalId: String,
            @SerializedName("platform")
            var platform: String,
            @SerializedName("requester_type")
            var requesterType: String,
            @SerializedName("reset_code")
            var resetCode: Any,
            @SerializedName("roles")
            var roles: List<Role>,
            @SerializedName("service_requester")
            var serviceRequester: ServiceRequester,
            @SerializedName("status")
            var status: String,
            @SerializedName("status_message")
            var statusMessage: String,
            @SerializedName("status_notes")
            var statusNotes: Any,
            @SerializedName("tax")
            var tax: String,
            @SerializedName("tax_image")
            var taxImage: Any,
            @SerializedName("tax_image_thumb")
            var taxImageThumb: String,
            @SerializedName("thumb_url")
            var thumbUrl: String,
            @SerializedName("updated_at")
            var updatedAt: String,
            @SerializedName("verification_code")
            var verificationCode: Any,
            @SerializedName("verification_updated_at")
            var verificationUpdatedAt: Any
        ) {
            data class Role(
                @SerializedName("created_at")
                var createdAt: String,
                @SerializedName("description")
                var description: String,
                @SerializedName("display_name")
                var displayName: String,
                @SerializedName("guard")
                var guard: String,
                @SerializedName("id")
                var id: Int,
                @SerializedName("main")
                var main: Int,
                @SerializedName("name")
                var name: String,
                @SerializedName("pivot")
                var pivot: Pivot,
                @SerializedName("updated_at")
                var updatedAt: String
            ) {
                data class Pivot(
                    @SerializedName("role_id")
                    var roleId: Int,
                    @SerializedName("user_id")
                    var userId: Int,
                    @SerializedName("user_type")
                    var userType: String
                )
            }

            data class ServiceRequester(
                @SerializedName("absher_number")
                var absherNumber: Any,
                @SerializedName("address")
                var address: String,
                @SerializedName("city_id")
                var cityId: Int,
                @SerializedName("commercial_registration")
                var commercialRegistration: String,
                @SerializedName("commercial_registration_expire_date")
                var commercialRegistrationExpireDate: Any,
                @SerializedName("commercial_registration_url")
                var commercialRegistrationUrl: String,
                @SerializedName("company_name")
                var companyName: String,
                @SerializedName("created_at")
                var createdAt: String,
                @SerializedName("id")
                var id: Int,
                @SerializedName("is_active")
                var isActive: Int,
                @SerializedName("latitude")
                var latitude: Double,
                @SerializedName("logo")
                var logo: String,
                @SerializedName("logo_thumb")
                var logoThumb: String,
                @SerializedName("logo_url")
                var logoUrl: String,
                @SerializedName("longitude")
                var longitude: Double,
                @SerializedName("region_id")
                var regionId: Any,
                @SerializedName("tax_number")
                var taxNumber: String,
                @SerializedName("tax_number_url")
                var taxNumberUrl: String,
                @SerializedName("updated_at")
                var updatedAt: String,
                @SerializedName("user_id")
                var userId: Int,
                @SerializedName("vat_certificate")
                var vatCertificate: Any,
                @SerializedName("vat_number")
                var vatNumber: Any
            )
        }
    }
}


    data class Errors(
        @SerializedName("email")
        var email: List<String>,
        @SerializedName("password")
        var password: List<String>
    )
