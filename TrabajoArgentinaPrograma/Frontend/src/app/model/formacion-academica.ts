export class FormacionAcademica {
    id!:number;
    nombreForm!:string;
    descripcionForm!:string;

    constructor(nombreForm:string, descripcionForm:string){
        this.nombreForm=nombreForm
        this.descripcionForm=descripcionForm
    }
}
