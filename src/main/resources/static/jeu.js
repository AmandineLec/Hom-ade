let button = document.getElementById("paramForm");
let modal = document.getElementById("modalParametre");

button.addEventListener("click", ()=>
    modal.classList.toggle("open"));

let buttonRecette = document.getElementById("RecetteButton");
let modalRecette = document.getElementById("modalRecette");

buttonRecette.addEventListener("click",()=>
    modalRecette.classList.toggle("open")); 

let buttonIventaire = document.getElementById("InventaireButton");
let modalInventaire = document.getElementById("modalInventaire");

buttonIventaire.addEventListener("click",() =>
    modalInventaire.classList.toggle("open"));