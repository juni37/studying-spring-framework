package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.memberdao.MemberDAO;
import member.memberdto.MemberDTO;
import util.Action;

public class CheckJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		MemberDTO dto = new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setTel1(request.getParameter("tel1"));
		dto.setTel2(request.getParameter("tel2"));
		dto.setTel3(request.getParameter("tel3")); 

		boolean check = MemberDAO.getInstance().insert(dto);
		
		String msg = null;
		String url = null;
		
		if(check) {
			msg = "ȸ�� ���� ����!! �α��� ������..";
			url = "/MyHome/login/login.do?id=" + dto.getId();
		}else {
			msg = "ȸ�� ���� ����!! ���� ��������..";
			url = "/MyHome/member/join.me";
		}
		
		request.setAttribute("check", check);
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
	}

}




