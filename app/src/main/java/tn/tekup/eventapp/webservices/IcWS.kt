package tn.tekup.eventapp.webservices


import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import tn.tekup.eventapp.models.Events
import tn.tekup.eventapp.models.LoginResponse
import tn.tekup.eventapp.models.Persons
import tn.tekup.eventapp.models.request.LoginReq
import tn.tekup.eventapp.models.request.PersonReq
import tn.tekup.eventapp.models.response.EventsResponse
import tn.tekup.eventapp.models.response.PersonResponse

interface IcWS {

    // Les anonces pour IC Anonyme
    @GET("api/Personnes")
    fun getPersons(@Header("Authorization") authrization: String): Call<PersonResponse>
    // Les anonces pour IC Anonyme
    @GET("api/Evenements")
    fun getEvents(@Header("Authorization") authrization: String): Call<EventsResponse>

    //login
    @POST("User/authenticate")
    fun userLogin(
        @Body login: LoginReq

    ): Call<LoginResponse>

    @Multipart
    @POST("api/Personnes")
    fun addPerson(
        @Header("Authorization") authrization: String,
        @Part("NomPer") NomPer: String,
        @Part("PrenomPer") prenomPer: String,
        @Part("DateDeNaissance") dateDeNaissance: String?,
        @Part("AdressePer") adressePer: String,
        @Part("Sexe") sexe: String,
        @Part("Bin") bin: String,
        @Part file: MultipartBody.Part?,
        @Part("Nationalite") nationalite: String,
        @Part("NomMere") nomMere: String,
        @Part("NomPere") nomPere: String,
        @Part("PersonEvents") personEvents: String?,
        @Part("Profession") profession: String,
        @Part("ReferenceCin") referenceCin: String

    ): Call<PersonReq>


    //edit profil
    //la 1er a supprimer
    @FormUrlEncoded
    @POST("ics/EditProfile")
    fun editProfile(
        @Header("X-AUTH-TOKEN") authrization: String,
        @Field("phone") phone: String?,
        @Field("fixe") fixe: String?,
        @Field("address") address: String?,
        @Field("addresssecond") addresssecond: String?,
        @Field("password") mdp: String?

    ): Call<Persons>

    @Multipart
    @POST("ics/EditProfile")
    fun editPhotoProfile(
        @Header("X-AUTH-TOKEN") authrization: String,
        @Part("phone") phone: RequestBody?,
        @Part("address") address: RequestBody?,
        @Part("address_second") address_second: RequestBody?,
        @Part picture: MultipartBody.Part?,
        @Part logo: MultipartBody.Part?


    ): Call<Events>


}

