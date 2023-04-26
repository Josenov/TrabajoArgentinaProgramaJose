import { Injectable } from '@angular/core';
import { Storage, getDownloadURL, list, ref}from '@angular/fire/storage';
import { uploadBytes } from '@angular/fire/storage';

@Injectable({
  providedIn: 'root'
})
export class ImgService {

  url : string = "";

  constructor(private storage:Storage) { }


  public subirImagen($event: any, name:string){
    const file = $event.target.files[0]
    const imgRef = ref(this.storage, `img/`+ name)
    uploadBytes(imgRef, file)
    .then(response =>{this.traerImg()})
    .catch(error => console.log(error)
    )
  }
  traerImg(){
    const imageRef = ref(this.storage, 'img')
    list(imageRef)
    .then(async response =>{
      for(let item of response.items){
        this.url = await getDownloadURL(item);
        console.log("URL es :" + this.url);
        
      }
    })
    .catch(error => console.log(error)) 
  }

}
