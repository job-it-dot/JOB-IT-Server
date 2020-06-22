package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompanyImage is a Querydsl query type for CompanyImage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanyImage extends EntityPathBase<CompanyImage> {

    private static final long serialVersionUID = 1049282082L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanyImage companyImage = new QCompanyImage("companyImage");

    public final QCompanys company;

    public final NumberPath<Long> companyImgId = createNumber("companyImgId", Long.class);

    public final StringPath companyImgName = createString("companyImgName");

    public QCompanyImage(String variable) {
        this(CompanyImage.class, forVariable(variable), INITS);
    }

    public QCompanyImage(Path<? extends CompanyImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanyImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanyImage(PathMetadata metadata, PathInits inits) {
        this(CompanyImage.class, metadata, inits);
    }

    public QCompanyImage(Class<? extends CompanyImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompanys(forProperty("company"), inits.get("company")) : null;
    }

}

