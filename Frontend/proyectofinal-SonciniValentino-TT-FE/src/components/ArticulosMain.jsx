import { useArticulosContext } from "../contexts/ArticulosContext";
import { useState, useEffect } from "react";

export default function Articulos(){
    const {listaProductos, obtenerProductos} = useArticulosContext();
    const [cargando, setCargando] = useState(true);
    const [error, setError] = useState(null);


     useEffect(() => { 
            obtenerProductos().then((listaProductos) =>{
                setCargando(false);
            }).catch((error) =>  {
                setError("Hubo un error en la carga de productos!");
                setCargando(false);
            })
      
        }, []);

        if(cargando){
            return(
                <div>
                    <p>Cargando...</p>
                </div>
            )
        }else if(error){
            return(
                <div>
                    <p>{error}</p>
                </div>
            )
        }else{
            return(
                <div>
                    {listaProductos.map((articulo) =>(
                        <table>
                            <tbody>
                                <tr>
                                    <th>{articulo.nombre}</th>
                                    <td>{articulo.precio}</td>
                                </tr>
                            </tbody>
                        </table>
                    ))}

                </div>
            )
        }
}