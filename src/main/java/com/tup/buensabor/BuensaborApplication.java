package com.tup.buensabor;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.enums.FormaPago;
import com.tup.buensabor.enums.TipoEnvio;
import com.tup.buensabor.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BuensaborApplication {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	CategoriaArticuloRepository categoriaArticuloRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
    @Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;
	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	ArticuloManufacturadoRepository articuloManufacturadoRepository;
	public static void main(String[] args) {
		SpringApplication.run(
				BuensaborApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			System.out.println("Boca");


		BigDecimal decimal = new BigDecimal("5443.00");
		BigDecimal decimal1 = new BigDecimal("10");
		BigDecimal decimal2 = new BigDecimal("5");
		BigDecimal decimal3 = new BigDecimal("10000");


		Date date = new Date();
		Usuario usuario = Usuario.builder()
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.auth0Id("1")
				.username("MiguelElMasQueSabe")
				.build();


		Cliente cliente = Cliente.builder()
				.email("boca@gmail.com")
				.apellido("Cruzliak")
				.nombre("Miguel")
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.telefono("2613615007")
				.build();

		ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.denominacion("Denominacion")
				.urlImagen("https://brandemia.org/contenido/subidas/2022/02/000-river-plate.jpg")
				.precioCompra(decimal)
				.stockActual(decimal1)
				.stockMinimo(decimal2)
				.build();

		ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
				.costo(decimal1)
				.precioVenta(decimal3)
				.tiempoEstimadoCocina(45)
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.urlImagen("https://brandemia.org/contenido/subidas/2022/02/000-river-plate.jpg")
				.descripcion("Boca")
				.denominacion("Denominacion").
				build();


		DetalleArticuloManufacturado detalleArticuloManufacturado = DetalleArticuloManufacturado.builder()
				.cantidad(decimal2)
				.build();

		DetalleFactura detalleFactura = DetalleFactura.builder()
				.cantidad(48)
				.subtotal(decimal1)
				.build();
		DetallePedido detallePedido = DetallePedido.builder()
				.cantidad(45)
				.subtotal(decimal)
				.subtotalCosto(decimal3)
				.build();
		Domicilio domicilio = Domicilio.builder()
				.codigoPostal(5516)
				.calle("Los Reyunos")
				.localidad("Guaymallen")
				.numero(4517)
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.numeroDpto(27)
				.pisoDpto(3)
				.build();

		Factura factura = Factura.builder()
				.formaPago(FormaPago.MERCADO_PAGO)
				.totalVenta(decimal3).fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.fechaFacturacion(date)
				.mpPreferenceId("prerenceID")
				.mpPaymentType("pmt")
				.mpMerchantOrderId(7981)
				.mpPaymentId(7848)
				.build();

		Pedido pedido = Pedido.builder()
				.total(decimal1)
				.totalCosto(decimal2)
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.fechaPedido(date)
				.estado(EstadoPedido.COMPLETADO)
				.formaPago(FormaPago.MERCADO_PAGO)
				.tipoEnvio(TipoEnvio.DELIVERY)
				.horaEstimadaFinalizacion(date)
				.build();

		UnidadMedida unidadMedida = UnidadMedida.builder()
				.abreviatura("KG")
				.denominacion("Masa")
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.build();
		CategoriaArticulo categoriaArticulo = CategoriaArticulo.builder()
				.denominacion("Carne")
				.fechaAlta(date)
				.fechaBaja(date)
				.fechaModificacion(date)
				.build();

		articuloInsumo.setCategoriaArticulo(categoriaArticulo);

			cliente.setUsuario(usuario);
			pedido.setCliente(cliente);
			pedido.setDomicilioEntrega(domicilio);
			factura.setPedido(pedido);
			domicilio.setCliente(cliente);
			detallePedido.setPedido(pedido);
			detallePedido.setArticuloManufacturado(articuloManufacturado);
			detallePedido.setArticuloInsumo(articuloInsumo);
			detalleArticuloManufacturado.setArticuloInsumo(articuloInsumo);
			detalleArticuloManufacturado.setArticuloManufacturado(articuloManufacturado);
			detalleFactura.setArticuloManufacturado(articuloManufacturado);
			detalleFactura.setArticuloInsumo(articuloInsumo);
			detalleFactura.setFactura(factura);
			articuloInsumo.setUnidadMedida(unidadMedida);
			unidadMedidaRepository.save(unidadMedida);
			categoriaArticuloRepository.save(categoriaArticulo);
			articuloInsumoRepository.save(articuloInsumo);
			usuarioRepository.save(usuario);
			clienteRepository.save(cliente);
			domicilioRepository.save(domicilio);
			pedidoRepository.save(pedido);
			facturaRepository.save(factura);
			articuloManufacturadoRepository.save(articuloManufacturado);
			detallePedidoRepository.save(detallePedido);
			facturaRepository.save(factura);
			detalleFacturaRepository.save(detalleFactura);
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado);



			};
		}



	}
