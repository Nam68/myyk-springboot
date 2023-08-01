package yk.web.myyk.backend.logic.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import yk.web.myyk.backend.dto.AccountBookDTO;
import yk.web.myyk.backend.entity.account.AccountBookAuthEntity;
import yk.web.myyk.backend.entity.account.AccountBookEntity;
import yk.web.myyk.backend.entity.member.MemberEntity;
import yk.web.myyk.backend.logic.BaseLogic;
import yk.web.myyk.backend.service.account.AccountBookService;
import yk.web.myyk.util.exception.SystemException;

@Service
public class AccountBookLogic extends BaseLogic implements AccountBookService {

	@Override
	@Transactional
	public List<AccountBookDTO> getAuthList(long memberIdx) throws SystemException {
		
		List<AccountBookAuthEntity> auths = getRepository().getAccountBookAuth()
				.findAllByMemberMemberIdxOrderByAccountBookAuthIdxAsc(memberIdx);
		
		List<AccountBookDTO> result = new ArrayList<>();
		for (AccountBookAuthEntity auth : auths) {
			AccountBookEntity entity = auth.getAccountBook();
			result.add(new AccountBookDTO(entity));
		}
		
		return result;
	}
	
	@Override
	@Transactional
	public void createBook(AccountBookDTO dto) throws SystemException {
		
		// 일단 재료가 되는 가계부 엔티티를 생성한다.
		AccountBookEntity book = new AccountBookEntity(dto);
		getRepository().getAccountBook().save(book);
		
		Map<Long, AccountBookAuthEntity> authMap = new HashMap<>();
		
		// 멤버를 불러와서 권한을 생성한다.
		for (long idx : dto.getWatchableIdx()) {
			MemberEntity member = getRepository().getMember().findById(idx).get();
			
			AccountBookAuthEntity auth = new AccountBookAuthEntity(member, book);
			authMap.put(idx, auth);
		}
		
		for (long idx : dto.getWritableIdx()) {
			AccountBookAuthEntity auth = authMap.get(idx);
			auth.setWritable(true);
		}
		
		for (Entry<Long, AccountBookAuthEntity> entry : authMap.entrySet()) {
			getRepository().getAccountBookAuth().save(entry.getValue());
		}
	}

}
