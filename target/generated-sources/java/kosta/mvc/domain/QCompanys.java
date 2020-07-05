package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCompanys is a Querydsl query type for Companys
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompanys extends EntityPathBase<Companys> {

    private static final long serialVersionUID = 674470106L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCompanys companys = new QCompanys("companys");

    public final ListPath<CompanyAddr, QCompanyAddr> companyAddrs = this.<CompanyAddr, QCompanyAddr>createList("companyAddrs", CompanyAddr.class, QCompanyAddr.class, PathInits.DIRECT2);

    public final StringPath companyDetail = createString("companyDetail");

    public final NumberPath<Integer> companyEmployeeCount = createNumber("companyEmployeeCount", Integer.class);

    public final NumberPath<Long> companyId = createNumber("companyId", Long.class);

    public final ListPath<CompanyImage, QCompanyImage> companyImages = this.<CompanyImage, QCompanyImage>createList("companyImages", CompanyImage.class, QCompanyImage.class, PathInits.DIRECT2);

    public final StringPath companyName = createString("companyName");

    public final NumberPath<Integer> companyPoints = createNumber("companyPoints", Integer.class);

    public final DateTimePath<java.util.Date> companyPremiumAt = createDateTime("companyPremiumAt", java.util.Date.class);

    public final QCompanyType companyType;

    public final QMembers member;

    public final ListPath<Perchase, QPerchase> perchases = this.<Perchase, QPerchase>createList("perchases", Perchase.class, QPerchase.class, PathInits.DIRECT2);

    public final ListPath<RecruitForm, QRecruitForm> recruitForms = this.<RecruitForm, QRecruitForm>createList("recruitForms", RecruitForm.class, QRecruitForm.class, PathInits.DIRECT2);

    public final ListPath<RecruitPlan, QRecruitPlan> recruitPlans = this.<RecruitPlan, QRecruitPlan>createList("recruitPlans", RecruitPlan.class, QRecruitPlan.class, PathInits.DIRECT2);

    public QCompanys(String variable) {
        this(Companys.class, forVariable(variable), INITS);
    }

    public QCompanys(Path<? extends Companys> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCompanys(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCompanys(PathMetadata metadata, PathInits inits) {
        this(Companys.class, metadata, inits);
    }

    public QCompanys(Class<? extends Companys> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.companyType = inits.isInitialized("companyType") ? new QCompanyType(forProperty("companyType")) : null;
        this.member = inits.isInitialized("member") ? new QMembers(forProperty("member")) : null;
    }

}

