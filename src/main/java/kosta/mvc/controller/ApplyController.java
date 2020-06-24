package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import kosta.mvc.domain.Recruit;
import kosta.mvc.domain.Resume;
import kosta.mvc.service.ApplyService;

@RestController
@RequestMapping("/apply")
@Api(tags = {"지원하기 Controller"})
public class ApplyController {
	
	@Autowired
	private ApplyService applyService;
	
	@ApiOperation(value = "지원하기")
	@PostMapping("/company")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = String.class )})
	public String apply(@ApiParam("공고ID")Long recruitId, @ApiParam("이력서id")Long resumeId) {
		int status = applyService.apply(recruitId, resumeId);
		
		String msg;
		
		if(status == 1) {
			msg = "지원이 성공적으로 이루어 졌습니다.";
		}else {
			msg = "지원이 불가 합니다.";
		}
		
		return msg;
	}
	
	@PostMapping("/cancle")
	@ApiOperation("지원 취소")
	public String cancleApply(@ApiParam("지원ID")Long applyId) {
		String message;
		int status = applyService.cancleApply(applyId);
		if(status == 0) {
			message = "지원 취소가 완료되지 않았습니다.";
		}else {
			message = "지원이 취소되었습니다.";
		}
		
		return message;
	}
	//지원한곳 지원상태 조회(서류 심사중, 서류 탈락, 서류 합격,면접 진행 중, 최종 합격) 조회
	@PostMapping("/showstatus")
	@ApiOperation("지원상태보기")
	public String showStatus(Long applyId) {
		String msg;
		int status = applyService.selectApplyStatus(applyId);
		if(status == 0) {
			msg = "서류심사중";
		}else if(status == 1) {
			msg = "서류탈락";
		}else if(status ==2) {
			msg = "서류합격";
		}else if(status ==3) {
			msg = "면접 진행 중";
		}else {
			msg = "최종 합격";
		}
		return msg;
	}
	
	@PostMapping("/showApplyList")
	@ApiOperation("지원회사 목록 보기")
	public List<Recruit> showApplyCompany(@ApiParam("유저ID")Long userId) throws NotFoundException{
		List<Recruit> list = applyService.selectApplyCompany(userId);
		if(list == null) {
			throw new NotFoundException("지원한 기업이 존재하지 않습니다.");
		}
		
		return list;
	}
}
