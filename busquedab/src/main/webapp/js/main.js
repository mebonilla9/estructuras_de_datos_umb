const miVue = new Vue({
    el: 'main',
    mounted(){
        this.cargarPersonas();
    },
    data: {
        personas:[],
        bPersona:null,
        posicionEncontrada:-1
    },
    methods:{
        cargarPersonas(){
            axios.post('http://localhost:8080/busquedab/api/persona/consultar')
            .then((respuesta) => {
                this.personas = respuesta.data.datos;
                console.log(respuesta.data.datos[0]);
            });
        },
        buscarPersona(){
            // initial values for start, middle and end
            let start = 0
            let stop = this.personas.length - 1
            let middle = Math.floor((start + stop) / 2)

            // While the middle is not what we're looking for and the list does not have a single item
            while (this.personas[middle].nombre !== this.bPersona && start < stop) {
                if (this.bPersona < this.personas[middle].nombre) {
                stop = middle - 1
                } else {
                start = middle + 1
                }

                // recalculate middle on every iteration
                middle = Math.floor((start + stop) / 2)
            }

            // if the current middle item is what we're looking for return it's index, else return -1
            this.posicionEncontrada = (this.personas[middle].nombre !== this.bPersona) ? -1 : middle;
        }
    }
});