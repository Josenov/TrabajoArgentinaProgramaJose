export class Proyectos {
    id?:number;
    nombreProyecto:string;
    descripcionProyecto:string;
    urlProyecto:string;
    imgProyecto:string;

    constructor(nombreProyecto:string, descripcionProyecto:string, urlProyecto:string, imgProyecto:string){
        this.nombreProyecto=nombreProyecto;
        this.descripcionProyecto=descripcionProyecto;
        this.urlProyecto=urlProyecto;
        this.imgProyecto=imgProyecto;
    }
}