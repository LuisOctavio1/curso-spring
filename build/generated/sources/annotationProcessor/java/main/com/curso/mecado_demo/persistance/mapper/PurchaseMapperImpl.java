package com.curso.mecado_demo.persistance.mapper;

import com.curso.mecado_demo.domain.Purchase;
import com.curso.mecado_demo.domain.PurchaseItem;
import com.curso.mecado_demo.persistance.entity.Compra;
import com.curso.mecado_demo.persistance.entity.ComprasProducto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T23:39:44-0600",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Autowired
    private PurchaseItemMapper purchaseItemMapper;

    @Override
    public Purchase toPurchase(Compra compra) {
        if ( compra == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        if ( compra.getIdCompra() != null ) {
            purchase.setPurchaseId( compra.getIdCompra() );
        }
        purchase.setClientId( compra.getIdCliente() );
        purchase.setDate( compra.getFecha() );
        purchase.setPaymentMethod( compra.getMedioPago() );
        purchase.setComment( compra.getComentario() );
        purchase.setState( compra.getEstado() );
        purchase.setItem( comprasProductoListToPurchaseItemList( compra.getProductos() ) );

        return purchase;
    }

    @Override
    public List<Purchase> toPurchases(List<Compra> compras) {
        if ( compras == null ) {
            return null;
        }

        List<Purchase> list = new ArrayList<Purchase>( compras.size() );
        for ( Compra compra : compras ) {
            list.add( toPurchase( compra ) );
        }

        return list;
    }

    @Override
    public Compra toCompra(Purchase pruchase) {
        if ( pruchase == null ) {
            return null;
        }

        Compra compra = new Compra();

        compra.setIdCompra( pruchase.getPurchaseId() );
        compra.setIdCliente( pruchase.getClientId() );
        compra.setFecha( pruchase.getDate() );
        compra.setMedioPago( pruchase.getPaymentMethod() );
        compra.setComentario( pruchase.getComment() );
        compra.setEstado( pruchase.getState() );
        compra.setProductos( purchaseItemListToComprasProductoList( pruchase.getItem() ) );

        return compra;
    }

    protected List<PurchaseItem> comprasProductoListToPurchaseItemList(List<ComprasProducto> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( ComprasProducto comprasProducto : list ) {
            list1.add( purchaseItemMapper.toPurchaseItem( comprasProducto ) );
        }

        return list1;
    }

    protected List<ComprasProducto> purchaseItemListToComprasProductoList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<ComprasProducto> list1 = new ArrayList<ComprasProducto>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( purchaseItemMapper.toComprasProducto( purchaseItem ) );
        }

        return list1;
    }
}
