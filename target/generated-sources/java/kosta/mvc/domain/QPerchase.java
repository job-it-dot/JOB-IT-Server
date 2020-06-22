package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerchase is a Querydsl query type for Perchase
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerchase extends EntityPathBase<Perchase> {

    private static final long serialVersionUID = 1702401589L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPerchase perchase = new QPerchase("perchase");

    public final QCompanys company;

    public final NumberPath<Long> perchaseId = createNumber("perchaseId", Long.class);

    public final NumberPath<Integer> perchasePrice = createNumber("perchasePrice", Integer.class);

    public final NumberPath<Integer> perchaseStatus = createNumber("perchaseStatus", Integer.class);

    public final DateTimePath<java.sql.Timestamp> perchaseTime = createDateTime("perchaseTime", java.sql.Timestamp.class);

    public final QProduct product;

    public QPerchase(String variable) {
        this(Perchase.class, forVariable(variable), INITS);
    }

    public QPerchase(Path<? extends Perchase> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPerchase(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPerchase(PathMetadata metadata, PathInits inits) {
        this(Perchase.class, metadata, inits);
    }

    public QPerchase(Class<? extends Perchase> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompanys(forProperty("company"), inits.get("company")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
    }

}

