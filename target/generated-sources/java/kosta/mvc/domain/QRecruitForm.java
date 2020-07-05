package kosta.mvc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecruitForm is a Querydsl query type for RecruitForm
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRecruitForm extends EntityPathBase<RecruitForm> {

    private static final long serialVersionUID = -1725842082L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecruitForm recruitForm = new QRecruitForm("recruitForm");

    public final QCompanys company;

    public final QRecruitAddr recruitAddr;

    public final NumberPath<Integer> recruitCareer = createNumber("recruitCareer", Integer.class);

    public final StringPath recruitDetail = createString("recruitDetail");

    public final DateTimePath<java.util.Date> recruitEndDate = createDateTime("recruitEndDate", java.util.Date.class);

    public final NumberPath<Long> recruitFormId = createNumber("recruitFormId", Long.class);

    public final StringPath recruitName = createString("recruitName");

    public final ListPath<Recruit, QRecruit> recruits = this.<Recruit, QRecruit>createList("recruits", Recruit.class, QRecruit.class, PathInits.DIRECT2);

    public final NumberPath<Integer> recruitSalary = createNumber("recruitSalary", Integer.class);

    public final NumberPath<Integer> recruitStatus = createNumber("recruitStatus", Integer.class);

    public final QRequiredEdu requiredEdu;

    public final ListPath<RequiredSkill, QRequiredSkill> requiredSkills = this.<RequiredSkill, QRequiredSkill>createList("requiredSkills", RequiredSkill.class, QRequiredSkill.class, PathInits.DIRECT2);

    public QRecruitForm(String variable) {
        this(RecruitForm.class, forVariable(variable), INITS);
    }

    public QRecruitForm(Path<? extends RecruitForm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecruitForm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecruitForm(PathMetadata metadata, PathInits inits) {
        this(RecruitForm.class, metadata, inits);
    }

    public QRecruitForm(Class<? extends RecruitForm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.company = inits.isInitialized("company") ? new QCompanys(forProperty("company"), inits.get("company")) : null;
        this.recruitAddr = inits.isInitialized("recruitAddr") ? new QRecruitAddr(forProperty("recruitAddr"), inits.get("recruitAddr")) : null;
        this.requiredEdu = inits.isInitialized("requiredEdu") ? new QRequiredEdu(forProperty("requiredEdu")) : null;
    }

}

