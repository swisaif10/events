package tn.tekup.eventapp.models.request

data class PersonReq(
    var nomPer: String?,
    var prenomPer: String?,
    var dateDeNaissance: String?,
    var adressePer: String?,
    var sexe: String?,
    var bin: String?,
    var imageProfile: String?,
    var nationalite: String?,
    var nomMere: String?,
    var nomPere: String?,
    var personEvents: Any?,
    var profession: String?,
    var referenceCin: String?
)