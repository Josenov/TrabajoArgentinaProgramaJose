export class ExperienciaLaboral {
    id!:number;
    nombreExpe!:string;
    descripcionExpe!:string;

    constructor(nombreExpe:string, descripcionExpe:string){
        this.nombreExpe=nombreExpe
        this.descripcionExpe=descripcionExpe
    }
}
