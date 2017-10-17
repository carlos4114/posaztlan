package mx.com.tecnetia.muvitul.negocio.dulceria.vo;

public class CineVO {
	private Integer idCine;
//	private Contacto contacto;
//	private Empresa empresa;
	private String nombre;
	private boolean activo;
	
//	private Set<ClasificacionArt> clasificacionArts = new HashSet<ClasificacionArt>(0);
//	private Set<Usuario> usuarios = new HashSet<Usuario>(0);
//	private Set<Articulo> articulos = new HashSet<Articulo>(0);
//	private Set<Sala> salas = new HashSet<Sala>(0);
//	private Set<PuntoVenta> puntoVentas = new HashSet<PuntoVenta>(0);
//	private Set<Formato> formatos = new HashSet<Formato>(0);
//	private Set<Usuario> usuarios_1 = new HashSet<Usuario>(0);
//	private Set<Proveedor> proveedors = new HashSet<Proveedor>(0);
//	private Set<Promocion> promocions = new HashSet<Promocion>(0);
//	private Set<Pelicula> peliculas = new HashSet<Pelicula>(0);
//	private Set<MateriaPrima> materiaPrimas = new HashSet<MateriaPrima>(0);
//	private Set<Paquete> paquetes = new HashSet<Paquete>(0);
//	private Set<ImpuestoBoleto> impuestoBoletos = new HashSet<ImpuestoBoleto>(0);
//	private Set<ImpuestoXProducto> impuestoXProductos = new HashSet<ImpuestoXProducto>(0);
//	private Set<Producto> productos = new HashSet<Producto>(0);
	
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	public Integer getIdCine() {
		return idCine;
	}
	public void setIdCine(Integer idCine) {
		this.idCine = idCine;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
